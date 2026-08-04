class Count {
    private int c = 0;
    public synchronized void increament(){
        for(int i = 0;i<100000;i++) c++;
    }
    public synchronized void decreament(){
        for(int i = 0;i<100000;i++) c--;
    }
    public int getcount(){
        return c;
    }
}