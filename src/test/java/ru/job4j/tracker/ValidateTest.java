package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.Validate;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.Stub;

import static org.assertj.core.api.Assertions.*;

class ValidateTest {

    @Test
    public void whenInvalidInput() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"one", "1"}
        );
        Validate input = new Validate(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInput() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"1"}
        );
        Validate input = new Validate(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenManyValidInput() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"1", "2", "4"}
        );
        Validate input = new Validate(out, in);
        int selected1 = input.askInt("Enter menu:");
        assertThat(selected1).isEqualTo(1);
        int selected2 = input.askInt("Enter menu:");
        assertThat(selected2).isEqualTo(2);
        int selected3 = input.askInt("Enter menu:");
        assertThat(selected3).isEqualTo(4);
    }

    @Test
    public void whenSubZeroInvalidInput() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"-1"}
        );
        Validate input = new Validate(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}