class UKOutletAdapter implements PowerSource {
    private UKOutlet ukOutlet;

    public UKOutletAdapter(UKOutlet ukOutlet) {
        this.ukOutlet = ukOutlet;
    }

    @Override
    public void connect() {
        ukOutlet.plugInUKDevice();  // Use the UK outlet-specific method to connect
    }

    @Override
    public void disconnect() {
        ukOutlet.unplugUKDevice();  // Use the UK outlet-specific method to disconnect
    }
}