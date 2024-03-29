package ru.itmo.webmail.web.page;

import ru.itmo.webmail.model.service.UserService;
import ru.itmo.webmail.web.annotation.Json;
import ru.itmo.webmail.web.exception.RedirectException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class UsersPage extends Page{
    @Override
    public void before(HttpServletRequest request, Map<String, Object> view) {
        super.before(request, view);

        if (getUser() == null) {
            throw new RedirectException("/index");
        }
    }

    private void action(HttpServletRequest request, Map<String, Object> view) {
        // No actions
    }

    @Json
    private void findAll(HttpServletRequest request, Map<String, Object> view){
        view.put("users", getUserService().findAll());
    }
    @Json
    private void find(HttpServletRequest request, Map<String, Object> view){
        view.put("user", getUserService().find(Long.parseLong(request.getParameter("userId"))));
    }
}
