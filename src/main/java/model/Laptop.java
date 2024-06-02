package model;

public class Laptop
{
    private String  model;
    private String processor;
    private String RAM;
    private String storage_drive;
    private String display;
    private String price;
    private int laptopsID;

    public Laptop( String model, String processor, String  RAM, String storage_drive, String display, String price, int laptopsID)
    {
        this.model = model;
        this.processor = processor;
        this.RAM = RAM;
        this.storage_drive = storage_drive;
        this.display = display;
        this.price = price;
        this.laptopsID = laptopsID;
    }

    public Laptop(String model, String processor, String RAM, String storage_drive, String display, String price)
    {
        this(model, processor, RAM, storage_drive, display, price, -1);
    }


    public int getId()
    {
        return laptopsID;
    }

    public String getModel()
    {
        return model;
    }

    public String getProcessor()
    {
        return processor;
    }

    public String getRAM()
    {
        return RAM;
    }

    public String getStorage_drive()
    {
        return storage_drive;
    }

    public String getDisplay()
    {
        return display;
    }

    public String getPrice()
    {
        return price;
    }


}
