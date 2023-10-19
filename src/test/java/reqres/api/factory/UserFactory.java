package reqres.api.factory;

import reqres.api.dto.ReqresUserDataDto;
import reqres.api.dto.ReqresUserDto;
import reqres.api.dto.ReqresUserSupportDto;

public class UserFactory {
    public static ReqresUserDto getNewUser(){
        ReqresUserDto user = new ReqresUserDto();
        ReqresUserDataDto userData = new ReqresUserDataDto();
        ReqresUserSupportDto userSupport = new ReqresUserSupportDto();
        userData.setId(-1);
        userData.setEmail("janet.weaver@reqres.in");
        userData.setFirstName("Janet");
        userData.setLastName("Weaver");
        userData.setAvatar("https://reqres.in/img/faces/2-image.jpg");
        userSupport.setUrl("https://reqres.in/#support-heading");
        userSupport.setText("To keep ReqRes free, contributions towards server costs are appreciated!");
        user.setData(userData);
        user.setSupport(userSupport);
        return user;
    }
}
