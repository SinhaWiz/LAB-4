public class ParserFactory {
    public static FileParser getParser(String fileType) throws IllegalArgumentException {
        if (fileType.equalsIgnoreCase("csv")){
            return new CSVParser();
        }
        else if(fileType.equalsIgnoreCase("json")) {
            return new JSONParser();
        }
        else if(fileType.equalsIgnoreCase("xml")){
                return new XMLParser();
        }
        else{
                throw new IllegalArgumentException("Unsupported file format: " + fileType);
        }
    }
}
