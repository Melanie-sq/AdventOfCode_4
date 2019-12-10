package de.smartsquare.aoc;

import de.smartsquare.aoc.Projekt;
import de.smartsquare.aoc.ProjektApplication;
import de.smartsquare.aoc.ProjektController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class ProjektTest {
    Projekt projekt = new Projekt();

    @Test
    public void findAllPasswords() {
        int start = 357253;
        int end = 892942;

        List<Integer> result = projekt.findPasswordsInRange(start, end);

        assertThat(result).contains(357788);
    }

    @Test
    public void printAllPasswords() {
        int start = 357253;
        int end = 357777;

        assertThat(projekt.findPasswordsInRange(start, end)).isNotNull();
    }

    @Test
    public void findFiveDigitPasswordShouldThrow() {
        int start = 35725;
        int end = 35777;

        assertThatThrownBy(()->{
            projekt.findPasswordsInRange(start, end);
        }).hasMessage("Not in range");
    }

    @Test
    public void findSevenDigitPasswordShouldThrow() {
        int start = 3572577;
        int end = 3577777;

        assertThatThrownBy(()->{
            projekt.findPasswordsInRange(start, end);
        }).hasMessage("Not in range");
    }

    /*@Test
    public void findAllPasswords() {
        int start = 357253;
        int end = 357778;

        int result = projekt.findPasswordsInRange(start, end);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void findAllPasswordsInRange() {
        int start = 357253;
        int end = 892942;

        int result = projekt.findPasswordsInRange(start, end);

        assertThat(result).isEqualTo(530);
    }

    @Test
    public void findAllPasswordsWithOnly2Doubles() {
        int start = 357253;
        int end = 892942;

        int result = projekt.findPasswordsInRange(start, end);

        assertThat(result).isNotNegative();
    }*/

}
