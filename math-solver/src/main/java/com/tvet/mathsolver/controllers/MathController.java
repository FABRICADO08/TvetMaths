package com.tvet.mathsolver.controllers;

import com.tvet.mathsolver.models.QuadraticInput;
import com.tvet.mathsolver.solvers.WebQuadraticSolver;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/solve") // Base URL for all API calls
public class MathController {

    @PostMapping("/quadratic")
    public String solveQuadratic(@RequestBody QuadraticInput input) {
        if (input.getA() == 0) {
            return "<strong>Error:</strong> 'a' cannot be zero in a quadratic equation.";
        }
        return WebQuadraticSolver.solve(input.getA(), input.getB(), input.getC());
    }
}
