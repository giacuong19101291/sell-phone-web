package controller;

import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Admin;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        int role = Integer.parseInt(request.getParameter("role")); // Lấy giá trị từ trường chọn

        // Kiểm tra xem người dùng đã nhập đủ thông tin chưa
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            // Tạo đối tượng Admin mới và lưu vào cơ sở dữ liệu
            Admin newAdmin = new Admin(username, password, role);
            DAO dao = new DAO();
            boolean success = dao.registerAccount(newAdmin);

            if (success) {
                // Đăng ký thành công, có thể chuyển hướng đến trang đăng nhập hoặc trang chính khác
                response.sendRedirect("login");
            } else {
                // Đăng ký thất bại, thông báo lỗi và giữ người dùng lại ở trang đăng ký
                request.setAttribute("error", "Đăng ký không thành công. Vui lòng thử lại!");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } else {
            // Người dùng không nhập đủ thông tin, giữ lại ở trang đăng ký
            request.setAttribute("error", "Vui lòng nhập đầy đủ thông tin đăng ký!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
