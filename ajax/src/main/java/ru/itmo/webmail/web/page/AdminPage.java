package ru.itmo.webmail.web.page;

import ru.itmo.webmail.web.exception.RedirectException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class AdminPage extends Page{
    @Override
    public void before(HttpServletRequest request, Map<String, Object> view) {
        super.before(request, view);
        if (getUser() == null) {
            throw new RedirectException("/index");
        }
    }

    private void action(HttpServletRequest request, Map<String, Object> view){
        view.put("users", getUserService().findAll());
    }

    private void changeAdminRoot(HttpServletRequest request, Map<String, Object> view){
        if(getUserService().find(getUser().getId()).isAdmin()){
            getUserService().changeAdminRoot(Integer.parseInt(request.getParameter("userid")));
        }
    }
}
