package com.brainlab;

import io.javalin.http.Context;
import org.json.simple.JSONObject;

import java.util.Arrays;

/**
 * This class contains all the callbacks for each route in the web API.
 */
class Routes {

    /**
     * Callback for the /calculator/add route. This takes one query parameter
     * called 'operands' which takes a comma separated list of floating point
     * values. The sum of these numbers is returned in JSON format.
     *
     * @param ctx Context object containing the request.
     */
    static void calculatorAdd(Context ctx) {

        // Query parameter is taken from the request
        String operandsParam = ctx.queryParam("operands");
        JSONObject jo = new JSONObject();

        // Check that operands parameter exists and is non-empty
        if (operandsParam != null && !operandsParam.isEmpty()) {

            // Split operands string based on commas
            String[] operandsSplit = operandsParam.split(",");
            double[] operands = new double[operandsSplit.length];

            // Parse each operand to a double
            for (int i = 0; i < operandsSplit.length; i++) {
                try {
                    operands[i] = Double.parseDouble(operandsSplit[i]);
                } catch (NumberFormatException e) {

                    // If an operand cannot be parsed, return an error
                    jo.put("error", e.getMessage());
                    ctx.json(jo);
                    return;
                }
            }

            // Sum the operands and return the result
            double sum = Arrays.stream(operands).reduce(0, Double::sum);
            jo.put("sum", sum);
            ctx.json(jo);
        }
        // Otherwise return 0
        else {
            jo.put("sum", 0);
            ctx.json(jo);
        }
    }

}
