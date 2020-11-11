package prc391.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prc391.api.services.UsersService;
import prc391.lib.models.UserModel;
import prc391.lib.models.common.BaseResponseModel;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/register")
    public ResponseEntity<BaseResponseModel> registerAccount(@RequestBody UserModel userDetail) {
        int result = this.usersService.registerAccount(userDetail);
        BaseResponseModel response = new BaseResponseModel(result);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/user")
    public ResponseEntity<BaseResponseModel> getUserDetail(@RequestParam(value = "email", required = false) final String email,
                                                           @RequestParam(value = "id", required = false) final Integer id) {
        List<UserModel> user = this.usersService.getUserDetail(email, id);

        if (user.isEmpty()) {
            return ResponseEntity.ok(new BaseResponseModel("User not found!"));
        }

        return ResponseEntity.ok(new BaseResponseModel(user));
    }

    @PutMapping("/update")
    public ResponseEntity<BaseResponseModel> updateUserInfor(@RequestBody final UserModel userModel) {
        return ResponseEntity.ok(new BaseResponseModel(this.usersService.updateUserInfo(userModel)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponseModel> deleteUser(@RequestParam("id") final Integer id) {
        return ResponseEntity.ok(new BaseResponseModel(this.usersService.deleteUser(id)));
    }
}
