package br.univel.view;

import br.univel.Main;

import java.util.Objects;

/**
 * Created by felipefrizzo on 15/11/16.
 */
public class RootLayoutController {
    private Main main;

    public void setMain(final Main main) {
        Objects.requireNonNull(main, "Main class cannot be null");

        this.main = main;
    }
}
