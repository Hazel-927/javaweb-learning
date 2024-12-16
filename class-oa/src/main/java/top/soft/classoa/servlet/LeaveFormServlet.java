package top.soft.classoa.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.soft.classoa.entity.LeaveForm;
import top.soft.classoa.service.LeaveFormService;
import top.soft.classoa.utils.ResponseUtils;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Hazel
 * @description: TODO
 * @date 2024/12/7 18:37
 */
@WebServlet("/api/leave/*")
public class LeaveFormServlet extends HttpServlet {
    private final LeaveFormService leaveFormService = new LeaveFormService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取前端的表单数据
        String url = req.getRequestURI();
        String methodName = url.substring(url.lastIndexOf("/") + 1);
        switch (methodName) {
            case "create":
                this.create(req, resp);
                break;
            case "list":
                this.list(req, resp);
                break;
            case "audit":
                this.audit(req, resp);
                break;
            default:
                System.out.println("请求错误");
        }
    }

    private void audit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String formId = req.getParameter("formId");
        String result = req.getParameter("result");
        String reason = req.getParameter("reason");
        String eid = req.getParameter("eid");

        ResponseUtils response;
        try {
            leaveFormService.audit(Long.parseLong(formId), Long.parseLong(eid), result, reason);
            response = new ResponseUtils();
        } catch (Exception e) {
            e.printStackTrace();
            response = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        resp.getWriter().println(response.toJsonString());
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employeeId = req.getParameter("eid");
        ResponseUtils result;
        try {
            List<Map<String, Object>> formList = leaveFormService.getLeaveFormList("process", Long.parseLong(employeeId));
            result = new ResponseUtils().put("list", formList);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResponseUtils(e.getClass().getSimpleName(), e.getMessage());
        }
        resp.getWriter().println(result.toJsonString());
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取前端的表单数据
        String employeeId = req.getParameter("eid");
        String formType = req.getParameter("formType");
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");
        String reason = req.getParameter("reason");

        // 生成请假单数据
        LeaveForm form = LeaveForm.builder()
                .employeeId(Long.parseLong(employeeId))
                .formType(Integer.parseInt(formType))
                .startTime(new Date(Long.parseLong(startTime)))
                .endTime(new Date(Long.parseLong(endTime)))
                .reason(reason)
                .createTime(new Date())
                .build();

        ResponseUtils result;
        try {
            LeaveForm leaveForm = leaveFormService.createLeaveForm(form);
            result = new ResponseUtils().put("leaveForm", leaveForm);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResponseUtils(getClass().getSimpleName(), e.getMessage());
        }
        resp.getWriter().println(result.toJsonString());
    }
}
