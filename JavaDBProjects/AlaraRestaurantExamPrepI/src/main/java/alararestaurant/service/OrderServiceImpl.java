package alararestaurant.service;

import alararestaurant.domain.dtos.importDtos.xmls.ItemDto;
import alararestaurant.domain.dtos.importDtos.xmls.OrderSeedDto;
import alararestaurant.domain.dtos.importDtos.xmls.OrderSeedRootDto;
import alararestaurant.domain.entities.Employee;
import alararestaurant.domain.entities.Item;
import alararestaurant.domain.entities.Order;
import alararestaurant.domain.entities.OrderItem;
import alararestaurant.domain.enums.OrderType;
import alararestaurant.repository.EmployeeRepository;
import alararestaurant.repository.ItemRepository;
import alararestaurant.repository.OrderRepository;
import alararestaurant.util.Constants;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import alararestaurant.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final EmployeeRepository employeeRepository;
    private final FileUtil fileUtil;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ItemRepository itemRepository, EmployeeRepository employeeRepository, FileUtil fileUtil, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.employeeRepository = employeeRepository;
        this.fileUtil = fileUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean ordersAreImported() {
        return this.orderRepository.count() > 0;
    }

    @Override
    public String readOrdersXmlFile() throws IOException {
        return fileUtil.readFile(Constants.ORDERS_INPUT_XML_FILE_PATH);
    }

    @Override
    public String importOrders() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        OrderSeedRootDto orderSeedRootDto = xmlParser.parseXml(OrderSeedRootDto.class, Constants.ORDERS_INPUT_XML_FILE_PATH);

        for (OrderSeedDto dto : orderSeedRootDto.getOrders()) {
            Employee employee = employeeRepository.findEmployeeByName(dto.getEmployee());

            if (employee != null) {
                boolean itemsAreValid = true;

                for (ItemDto item : dto.getItems().getItems()) {
                    Item entityItem = itemRepository.findItemByName(item.getName());

                    if (entityItem == null) {
                        itemsAreValid = false;
                        break;
                    }
                }

                if (itemsAreValid) {
                    Order entity = modelMapper.map(dto, Order.class);
                    entity.setType(OrderType.valueOf(dto.getType()));
                    entity.setEmployee(employee);
                    List<OrderItem> orderItems = new ArrayList<>();
                    for (ItemDto itemDto : dto.getItems().getItems()) {
                        OrderItem map = modelMapper.map(itemDto, OrderItem.class);
                        map.setOrder(entity);
                        map.setItem(itemRepository.findItemByName(itemDto.getName()));
                        orderItems.add(map);
                    }

                    boolean validQuantities = true;
                    for (OrderItem orderItem : orderItems) {
                        if (!validationUtil.isValid(orderItem)) {
                            validationUtil.validate(orderItem).forEach(v -> System.out.println(v.getMessage()));

                            validQuantities = false;
                        }
                    }

                    if (!validQuantities) {
                        continue;
                    }

                    entity.setOrderItems(orderItems);

                    if (!validationUtil.isValid(entity)) {
                        validationUtil.validate(entity).forEach(v -> System.out.println(v.getMessage()));

                        continue;
                    }

                    orderRepository.saveAndFlush(entity);
                    sb.append(String.format("Order for %s on %s added", entity.getCustomer(), entity.getDateTime()));
                }
            }
        }


        return null;
    }

    @Override
    public String exportOrdersFinishedByTheBurgerFlippers() {
        List<Employee> burgerFlippers = employeeRepository.findAllByPositionName("Burger Flipper");

        StringBuilder sb = new StringBuilder();

        for (Employee employee : burgerFlippers) {
            List<Order> orders = orderRepository.findAllByEmployee_NameOrderByEmployeeAscIdAsc(employee.getName());

            sb.append(String.format("Name: %s%nOrders:%n", employee.getName()));
            if (orders.size() == 0) {
                sb.append("\tNone\n");
            }

            for (Order order : orders) {
                sb.append(String.format("  Customer: %s%n  Items:%n", order.getCustomer()));
                order.getOrderItems().forEach(oi -> sb.append(String.format("\tName: %s%n\tPrice: %s%n\tQuantity: %d%n%n", oi.getItem().getName(),
                        oi.getItem().getPrice(), oi.getQuantity())));
            }
        }

        return sb.toString().trim();
    }
}
