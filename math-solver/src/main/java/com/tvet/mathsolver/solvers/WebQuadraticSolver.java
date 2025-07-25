package com.tvet.mathsolver.solvers;

public class WebQuadraticSolver {

    public static String solve(double a, double b, double c) {
        StringBuilder solutionSteps = new StringBuilder();

        solutionSteps.append(String.format("<strong>Problem:</strong> Solve %.2fx^2 + %.2fx + %.2fx = 0\n", a, b, c));
        solutionSteps.append("---------------------------------\n\n");

        solutionSteps.append("<strong>Step 1:</strong> Use the Quadratic Formula.\n");
        solutionSteps.append("   x = [-b ± sqrt(b^2 - 4ac)] / 2a\n\n");

        double discriminant = (b * b) - (4 * a * c);
        solutionSteps.append("<strong>Step 2:</strong> Calculate the discriminant (Δ = b^2 - 4ac).\n");
        solutionSteps.append(String.format("   Δ = (%.2f)^2 - 4 * (%.2f) * (%.2f)\n", b, a, c));
        solutionSteps.append(String.format("   Δ = %.2f - %.2f\n", (b * b), (4 * a * c)));
        solutionSteps.append(String.format("   Δ = %.2f\n\n", discriminant));

        solutionSteps.append("<strong>Step 3:</strong> Find the roots based on the discriminant.\n");
        if (discriminant > 0) {
            solutionSteps.append("Since Δ is positive, there are two distinct real roots.\n");
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            solutionSteps.append(String.format("   x1 = %.4f\n   x2 = %.4f\n\n", root1, root2));
            solutionSteps.append(String.format("<strong>SOLUTION: The roots are x1 = %.4f and x2 = %.4f</strong>", root1, root2));
        } else if (discriminant == 0) {
            solutionSteps.append("Since Δ is zero, there is exactly one real root.\n");
            double root = -b / (2 * a);
            solutionSteps.append(String.format("   x = %.4f\n\n", root));
            solutionSteps.append(String.format("<strong>SOLUTION: The single root is x = %.4f</strong>", root));
        } else {
            solutionSteps.append("Since Δ is negative, there are two complex roots.\n");
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            solutionSteps.append(String.format("   x1 = %.4f + %.4fi\n   x2 = %.4f - %.4fi\n\n", realPart, imaginaryPart, realPart, imaginaryPart));
            solutionSteps.append(String.format("<strong>SOLUTION: The roots are x1 = %.4f + %.4fi and x2 = %.4f - %.4fi</strong>", realPart, imaginaryPart, realPart, imaginaryPart));
        }
        
        return solutionSteps.toString();
    }
}
