/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Map;

/**
 *
 * @author Harpo
 */
public class InterceptorSession implements Interceptor{

    @Override
    public void destroy() {
        
    }

    @Override
    public void init() {
        
    }

    @Override
    public String intercept(ActionInvocation actionInvoked) throws Exception {
        Map session = actionInvoked.getInvocationContext().getSession();
        if (session.containsKey("logged")) {
            String resultado = actionInvoked.invoke();
            return resultado;
        }else{
            return "noLogin";
        }
        
    }
    
}
