package com.example.application.views.main;

import com.example.application.security.SecurityService;
import com.example.application.views.main.sections.Contact;
import com.example.application.views.main.sections.Experience;
import com.example.application.views.main.sections.Introduction;
import com.example.application.views.main.sections.Projects;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Main")
@Route(value = "")
@AnonymousAllowed
public class MainView extends VerticalLayout {
    NavBar navBar;
    public MainView(SecurityService securityService) {
        this.navBar = new NavBar(securityService);
        Projects projects = new Projects();
        setPadding(false);
        addClassNames("main-view", LumoUtility.Overflow.HIDDEN);
        Introduction introduction = new Introduction();
        Experience experience = new Experience();
        Contact contact = new Contact();
        this.navBar.addSections(introduction, projects, experience, contact);

        ScrollableContent scrollableContent = new ScrollableContent(introduction, projects, experience, contact);
        scrollableContent.addClassNames("hidden-scroller", "content", LumoUtility.Overflow.SCROLL);
        add(this.navBar, scrollableContent);
    }

    public void setActiveTab(String label) {
        this.navBar.setActiveTab(label);
    }
}
