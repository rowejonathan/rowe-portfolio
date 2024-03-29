package com.example.application.views.main;

import com.example.application.views.main.sections.Contact;
import com.example.application.views.main.sections.Experience;
import com.example.application.views.main.sections.Introduction;
import com.example.application.views.main.sections.Projects;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Main")
@Route(value = "")
@AnonymousAllowed
@SpringComponent
@UIScope
public class MainView extends VerticalLayout {

public MainView(NavBar navBar, Projects projects) {

        setPadding(false);
        addClassNames("main-view", LumoUtility.Overflow.HIDDEN);
        Introduction introduction = new Introduction();
        Experience experience = new Experience();
        Contact contact = new Contact();
        navBar.addSections(introduction, projects, experience, contact);

        VerticalLayout scrollableContent = new VerticalLayout(introduction, projects, experience, contact);
        scrollableContent.addClassNames("hidden-scroller", "content", LumoUtility.Overflow.SCROLL);
        add(navBar, scrollableContent);
    }
}
