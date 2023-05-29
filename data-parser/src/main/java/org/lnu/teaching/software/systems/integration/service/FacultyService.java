package org.lnu.teaching.software.systems.integration.service;

import org.lnu.teaching.software.systems.integration.entity.Faculty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacultyService {
    private static final String FACULTIES_PAGE_URL = "https://lnu.edu.ua/about/faculties";

    public List<Faculty> findFaculties() {
        List<Faculty> faculties = new ArrayList<>();
        try {
            WebDriver driver = new ChromeDriver();

            driver.get(FACULTIES_PAGE_URL);

            List<WebElement> facultyNodes = driver.findElements(By.cssSelector("li.clearfix"));
            facultyNodes.forEach(facultyNode -> {
                Faculty faculty = parseFaculty(facultyNode);
                faculties.add(faculty);
            });

            driver.quit();

            return faculties;
        } catch (RuntimeException e) {
            e.printStackTrace();

            return faculties;
        }
    }

    private Faculty parseFaculty(WebElement facultyNode) {
        Faculty faculty = new Faculty();

        String name = facultyNode.findElement(By.tagName("h2")).getText();
        faculty.setName(name);

        List<WebElement> valueNodes = facultyNode.findElements(By.cssSelector(".details .value"));

        String website = valueNodes.get(3).getText();
        faculty.setWebsite(website);

        String email = valueNodes.get(2).getText();
        faculty.setEmail(email);

        String phone = valueNodes.get(1).getText();
        faculty.setPhone(phone);

        String address = valueNodes.get(0).getText();
        faculty.setAddress(address);

        String info = "Детальну інформацію про факультет можна знайти на сайті факультету " + website;
        faculty.setInfo(info);

        return faculty;
    }
}
