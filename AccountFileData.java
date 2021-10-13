package ku.cs.controllers.admin;

import java.io.*;

public class AccountFileData implements ku.cs.controllers.admin.AccountData {
    private String fileDirectoryName;
    private String fileName;
    private Account admin = new Account();

    public AccountFileData(String fileDirectoryName, String fileName) {
        this.fileDirectoryName = fileDirectoryName;
        this.fileName = fileName;
        checkFileIsExisted();
    }

    private void checkFileIsExisted() {
        File file = new File(fileDirectoryName);
        if (!file.exists()) {
            file.mkdirs();
        }
        String filePath = fileDirectoryName + File.separator + fileName;
        file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Cannot create " + filePath);
            }
        }
    }

    private void readData() throws IOException {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = "";
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            Account newAdmin = new Account(data[0], data[1]);
            this.admin.add(newAdmin);
        }
        reader.close();
    }

    @Override
    public Account getAccount() {
        try {
            readData();
        } catch (FileNotFoundException ex) {
            System.err.println(this.fileName + " not found");
        } catch (IOException ex) {
            System.err.println("IOException from reading " + this.fileName);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Array index out from reading " + this.fileName);
        }
        return this.admin;
    }

    @Override
    public void setAccountData(Account acc) throws IOException {
        String filePath = fileDirectoryName + File.separator + fileName;
        File file = new File(filePath);
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (Account s : acc.getAccounts()) {
                String line = s.getUsername() + ","
                        + s.getPassword();
                writer.append(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Cannot write " + filePath);
        }
    }

}
