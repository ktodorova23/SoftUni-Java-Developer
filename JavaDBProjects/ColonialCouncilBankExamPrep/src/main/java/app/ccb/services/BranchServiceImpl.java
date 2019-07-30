package app.ccb.services;

import app.ccb.domain.dtos.importDtos.BranchSeedDto;
import app.ccb.domain.entities.Branch;
import app.ccb.repositories.BranchRepository;
import app.ccb.util.Constants;
import app.ccb.util.FileUtil;
import app.ccb.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, FileUtil fileUtil, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.branchRepository = branchRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean branchesAreImported() {
        return this.branchRepository.count() != 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return this.fileUtil.readFile(Constants.BRANCHES_IMPORT_JSON_FILE_PATH);
    }

    @Override
    public String importBranches(String branchesJson) throws IOException {
        StringBuilder sb = new StringBuilder();

        BranchSeedDto[] branchSeedDtos = this.gson.fromJson(this.readBranchesJsonFile(), BranchSeedDto[].class);

        for (BranchSeedDto dto : branchSeedDtos) {
            Branch entity = this.modelMapper.map(dto, Branch.class);
            if (!validationUtil.isValid(entity)) {
                sb.append(Constants.INCORECT_DATA_MESSAGE).append(System.lineSeparator());
            } else {
                this.branchRepository.saveAndFlush(entity);
                sb.append(String.format(Constants.SUCCESSFUL_DATA_IMPORT_MESSAGE, Branch.class.getSimpleName(), entity.getName()))
                        .append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
