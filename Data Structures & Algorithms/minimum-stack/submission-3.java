class MinStack {
Stack<int[]> result;
    public MinStack() {
        result = new Stack<>();
    }
    
    public void push(int val) {
        if(result.isEmpty()){
            result.push(new int[] {val,val});
        }
        else{
            int CurrentMin = Math.min(val,result.peek()[1]);
            result.push(new int[] {val,CurrentMin});
        }
    }
    
    public void pop() {
        result.pop();
    }
    
    public int top() {
        return result.peek()[0];
    }
    
    public int getMin() {
        return result.peek()[1];
    }
}
