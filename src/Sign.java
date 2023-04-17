public enum Sign {
    GREATER(">"),
    GREATEROREVEN(">="),
    LESS("<"),
    LESSOREVEN("<=");
    private String body;
    Sign(String body)
    {
        this.body=body;
    }
    public String getBody()
    {
        return body;
    }
}
