package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping(value = "/calc")
    public String calculate(@RequestParam(value = "operand1", required = false) int operand1,
                            @RequestParam(value = "operand2", required = false) int operand2,
                            @RequestParam(value = "operator", required = false) String operator,
                            Model model) {
        double result = 0.0;
        switch (operator) {
            case "add":
                result = operand1 + operand2;
                break;
            case "subtract":
                result = operand1 - operand2;
                break;
            case "multiply":
                result = operand1 * operand2;
                break;
            case "divide":
                result = (double) operand1 / operand2;
                break;
        }
        model.addAttribute("result", result);
        return "calc";
    }
}
