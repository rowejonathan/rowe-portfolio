package com.example.application.views.main;

import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterListener;
import com.vaadin.flow.router.Route;


@Route("login")
public class LoginView extends Dialog implements BeforeEnterListener {

    LoginForm loginForm = new LoginForm();
    public LoginView() {
        addClassNames("login-view");
        this.loginForm.setAction("login");
        add(loginForm);
    }

    public void open() {
        setOpened(true);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            this.loginForm.setError(true);
        }
    }
}
