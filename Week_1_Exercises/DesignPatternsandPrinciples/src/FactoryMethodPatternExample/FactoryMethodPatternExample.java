package FactoryMethodPatternExample;

interface DocumentType {
    void open();
}

class WordDocumentType implements DocumentType {
    @Override
    public void open() {
        System.out.println("Opening Word Document.");
    }
}

class PdfDocumentType implements DocumentType {
    @Override
    public void open() {
        System.out.println("Opening PDF Document.");
    }
}

class ExcelDocumentType implements DocumentType {
    @Override
    public void open() {
        System.out.println("Opening Excel Document.");
    }
}

abstract class DocumentFactoryCreator {
    public abstract DocumentType createDocument();
}

class WordDocumentFactoryCreator extends DocumentFactoryCreator {
    @Override
    public DocumentType createDocument() {
        return new WordDocumentType();
    }
}

class PdfDocumentFactoryCreator extends DocumentFactoryCreator {
    @Override
    public DocumentType createDocument() {
        return new PdfDocumentType();
    }
}

class ExcelDocumentFactoryCreator extends DocumentFactoryCreator {
    @Override
    public DocumentType createDocument() {
        return new ExcelDocumentType();
    }
}

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        DocumentFactoryCreator wordDocumentFactoryCreator = new WordDocumentFactoryCreator();
        DocumentType wordDocument = wordDocumentFactoryCreator.createDocument();
        wordDocument.open();

        DocumentFactoryCreator pdfDocumentFactoryCreator = new PdfDocumentFactoryCreator();
        DocumentType pdfDocument = pdfDocumentFactoryCreator.createDocument();
        pdfDocument.open();

        DocumentFactoryCreator excelDocumentFactoryCreator = new ExcelDocumentFactoryCreator();
        DocumentType excelDocument = excelDocumentFactoryCreator.createDocument();
        excelDocument.open();
    }
}
