import com.scl.bean.Student;
import com.scl.bean.User;
import com.scl.controller.UserController;
import com.scl.service.Autowired;
import com.scl.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author scl
 * @Date 2020/6/28
 * @Description
 */
public class MyTest {

    /**
     *
     */
    @Test
    public void demo() throws Exception {
        UserController userController = new UserController();
        UserService service = new UserService();

        Class<? extends UserController> clazz = userController.getClass();

        Field userService = clazz.getDeclaredField("userService");
//        userService.setAccessible(true);
//        userService.set(userController,service);
        String name = userService.getName();
        name ="set"+ name.substring(0,1).toUpperCase()+name.substring(1,name.length());
        System.out.println(name);

        Method method = clazz.getMethod(name, UserService.class);
        System.out.println(method);
        method.invoke(userController,service);

        System.out.println(userController.getUserService());
    }

    /**
     *
     */
    @Test
    public void demo02() throws Exception {
        UserController userController = new UserController();
        Class<? extends UserController> userControllerClass = userController.getClass();
        Arrays.stream(userControllerClass.getDeclaredFields()).forEach(field -> {
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation == null){
                field.setAccessible(true);
                Class<?> type = field.getType();
                try {
                    Object newInstance = type.getConstructor().newInstance();
                    field.set(userController,newInstance);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        System.out.println(userController.getUserService());


    }


    /**
     *
     */
    @Test
    public void testSpring() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");


        User bean = (User) ac.getBean("user");
        Student student = ac.getBean(Student.class);
        System.out.println(student);
        System.out.println(bean);
    }
}
