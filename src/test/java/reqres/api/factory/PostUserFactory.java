package reqres.api.factory;

import com.github.javafaker.Faker;
import reqres.api.dto.PostReqresUser;

import java.util.Locale;

public class PostUserFactory {
    public static PostReqresUser getNewPostUser(){
        Faker faker = new Faker(new Locale("ru"));
        var user = new PostReqresUser();
        user.setName(faker.name().firstName());
        user.setJob(faker.job().field());
        return user;
    }
}
