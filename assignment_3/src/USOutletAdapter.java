class USOutletAdapter implements PowerSource {
    private USOutlet usOutlet;

    public USOutletAdapter(USOutlet usOutlet) {
        this.usOutlet = usOutlet;
    }

    @Override
    public void connect() {
        usOutlet.plugInUSDevice();  // Use the US outlet-specific method to connect
    }

    @Override
    public void disconnect() {
        usOutlet.unplugUSDevice();  // Use the US outlet-specific method to disconnect
    }
}