
interface Document {
    void display();
}

abstract class WordDocument implements Document {
    @Override
    public void display() {
        System.out.println("Open WordDocument..");
    }
}

abstract class PdfDocument implements Document {
    @Override
    public void display() {
        System.out.println("Open PdfDocument..");
    }
}

abstract class ExcelDocument implements Document {
    @Override
    public void display() {
        System.out.println("Open ExcelDocument..");
    }
}

class WordDoc2003 extends WordDocument {
    @Override
    public void display() {
        System.out.println("Displaying Word2003 Document..");
    }
}

class PdfDoc extends PdfDocument {
    @Override
    public void display() {
        System.out.println("Displaying Pdf Document..");
    }
}

class ExcelDoc2003 extends ExcelDocument {
    @Override
    public void display() {
        System.out.println("Displaying Excel2003 Document..");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDoc2003();
    }
}

class PdfFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDoc();
    }
}

class ExcelFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDoc2003();
    }
}

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        DocumentFactory factory;

        factory = new WordFactory();
        Document wordDoc = factory.createDocument();
        wordDoc.display();

        factory = new PdfFactory();
        Document pdfDoc = factory.createDocument();
        pdfDoc.display();

        factory = new ExcelFactory();
        Document excelDoc = factory.createDocument();
        excelDoc.display();
    }
}
