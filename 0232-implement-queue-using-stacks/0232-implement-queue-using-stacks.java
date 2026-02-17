class MyQueue {

    private Stack<Integer> stk;
    private Stack<Integer> cache;

    public MyQueue() {
        stk = new Stack<>();
        cache = new Stack<>();
    }

    private void cacheJob() {
        while(!stk.isEmpty()) {
            cache.push(stk.pop());
        }
    }

    private void unCacheJob() {
        while(!cache.isEmpty()) {
            stk.push(cache.pop());
        }
    }
    
    public void push(int x) {
        stk.push(x);
    }
    
    public int pop() {
        this.cacheJob();
        int answer = cache.pop();
        this.unCacheJob();
        return answer;
    }
    
    public int peek() {
        this.cacheJob();
        int answer = cache.peek();
        this.unCacheJob();
        return answer;
    }
    
    public boolean empty() {
        return stk.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */