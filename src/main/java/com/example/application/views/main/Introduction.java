package com.example.application.views.main;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;

public class Introduction extends Div {
    public Introduction() {
        addClassName("introduction");
        add(new Paragraph("As a seasoned Full Stack Software Engineer with nearly a decade of experience, I bring a wealth of expertise in crafting innovative solutions across a diverse range of projects. Throughout my career, I've spearheaded initiatives, collaborated with multidisciplinary teams, and leveraged cutting-edge technologies to drive efficiency, enhance functionality, and elevate user experiences."));
        add(new Paragraph("My journey in Software Engineering began my first semester in Engineering. That was when I discovered my innate passion for problem-solving and the transformative power of software development. I changed my major and since then, I've dedicated myself to mastering the craft, continuously honing my skills and embracing new challenges with enthusiasm."));
        add(new Paragraph("My superpower lies in my ability to envision and architect comprehensive solutions from inception to execution. Throughout every phase of development, I thrive on analyzing scenarios, anticipating challenges, and devising optimal strategies to realize project objectives effectively. " +
                "In essence, my passion for software engineering is fueled by the opportunity to create impactful solutions that not only address immediate needs but also pave the way for future innovation and advancement. " +
                "With a relentless commitment to excellence and a penchant for problem-solving, I eagerly anticipate the next challenge and the opportunity to continue pushing the boundaries of possibility in the realm of software development."
        ));
    }
}
