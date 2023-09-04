package crud.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通知浏览器不要缓存
        resp.setHeader("pragma", "no-cache");
        resp.setHeader("cache-control", "no-cache");
        resp.setHeader("expires", "0");

        int width = 200; // Increase the width for larger text
        int height = 100; // Increase the height for larger text

// Create an object to store the image in memory
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

// Beautify the image
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.PINK);
        graphics.fillRect(0, 0, width, height);

// Add a border
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0, 0, width - 1, height - 1);

// Set the font size and style for clearer text
        Font font = new Font("Arial", Font.BOLD, 36); // You can adjust the font family, style, and size as needed
        graphics.setFont(font);

// Generate and draw the captcha text
        graphics.setColor(Color.GREEN);
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            sb.append(ch);

            graphics.drawString(ch + "", width / 5 * i - 20, height / 2 + 20); // Adjust the position of the text
        }

// Store the captcha in the session
        String checkCode_session = sb.toString();
        req.getSession().setAttribute("checkCode_session", checkCode_session);

// Add some interference lines
        graphics.setColor(Color.GRAY);

        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);

            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1, y1, x2, y2);
        }

// Output the image to the page
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
