package xtu.cie.ldj;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] strs = path.split("/");
        for (int i = 0; i < strs.length; i++) {
        	if(strs[i].length() == 0 || strs[i].equals("."))
        		continue;
        	if(strs[i].equals("..")){
        		if(stack.size() > 0)
        			stack.pop();
        	}else {
				stack.push(strs[i]);
			}
        }
        
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("/");
        for (int i = 0; i < stack.size(); i++) {
        	sBuilder.append(stack.get(i));
        	if(i < stack.size() - 1)
        		sBuilder.append("/");
		}
        return sBuilder.toString();
    }
    
    public static void main(String[] args) {
    	SimplifyPath simplifyPath = new SimplifyPath();
    	System.out.println(simplifyPath.simplifyPath("/home/"));
    	System.out.println(simplifyPath.simplifyPath("/a/./b/../../c/"));
    	System.out.println(simplifyPath.simplifyPath("/"));
	}
}
