package kr.co.fastcampus.admin.service;

import kr.co.fastcampus.admin.ifs.CrudInterface;
import kr.co.fastcampus.admin.model.entity.AdminUser;
import kr.co.fastcampus.admin.model.network.Header;
import kr.co.fastcampus.admin.model.network.request.AdminUserApiRequest;
import kr.co.fastcampus.admin.model.network.response.AdminUserApiResponse;
import kr.co.fastcampus.admin.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Service
public class AdminUserApiLoginService implements CrudInterface<AdminUserApiRequest, AdminUserApiResponse> {

    @Autowired
    AdminUserRepository adminUserRepository;

    @Override
    public Header<AdminUserApiResponse> create(Header<AdminUserApiRequest> request) {
        AdminUserApiRequest adminUserApiRequest = request.getData();

        AdminUser adminUser = AdminUser.builder()
                .id(adminUserApiRequest.getId())
                .account(adminUserApiRequest.getAccount())
                .password(adminUserApiRequest.getPassword())
                .status(adminUserApiRequest.getStatus())
                .role(adminUserApiRequest.getRole())
                .lastLoginAt(adminUserApiRequest.getLastLoginAt())
                .passwordUpdatedAt(adminUserApiRequest.getPasswordUpdatedAt())
                .loginFailCount(adminUserApiRequest.getLoginFailCount())
                .registeredAt(LocalDateTime.now())
                .build();

        AdminUser newAdminUser = adminUserRepository.save(adminUser);

        return response(newAdminUser);
    }


    @Override
    public Header<AdminUserApiResponse> read(Long id) {
        return adminUserRepository.findById(id)
                .map(adminUser->response(adminUser))
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<AdminUserApiResponse> update(Header<AdminUserApiRequest> request) {
        AdminUserApiRequest adminUserApiRequest = request.getData();

        return adminUserRepository.findById(adminUserApiRequest.getId())
                .map(adminUser -> {

                    adminUser.setPassword(adminUserApiRequest.getPassword())
                            .setStatus(adminUserApiRequest.getStatus())
                            .setRole(adminUserApiRequest.getRole())
                            .setLastLoginAt(adminUserApiRequest.getLastLoginAt())
                            .setPasswordUpdatedAt(adminUserApiRequest.getPasswordUpdatedAt())
                            .setLoginFailCount(adminUserApiRequest.getLoginFailCount());


                    return adminUser;
                })
                .map(adminUser -> adminUserRepository.save(adminUser))
                .map(adminUser -> response(adminUser))
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        return adminUserRepository.findById(id)
                .map(adminUser -> {
                    adminUserRepository.delete(adminUser);
                    return Header.OK();
                })
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    private Header<AdminUserApiResponse> response(AdminUser AdminUser) {
        AdminUserApiResponse adminUserApiResponse = AdminUserApiResponse.builder()
                .id(AdminUser.getId())
                .account(AdminUser.getAccount())
                .password(AdminUser.getPassword())
                .status(AdminUser.getStatus())
                .role(AdminUser.getRole())
                .lastLoginAt(AdminUser.getLastLoginAt())
                .passwordUpdatedAt(AdminUser.getPasswordUpdatedAt())
                .loginFailCount(AdminUser.getLoginFailCount())
                .registeredAt(AdminUser.getRegisteredAt())
                .unregisteredAt(AdminUser.getUnregisteredAt())
                .build();

        return Header.OK(adminUserApiResponse);
    }
}
