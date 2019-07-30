package com.softuni.xmlprocessingcardealerhomework.services.base;

import com.softuni.xmlprocessingcardealerhomework.domain.dtos.outputDtos.SaleInformationRootDto;

public interface SaleService {
    void seedSales();

    SaleInformationRootDto getSalesWithInfo();
}
