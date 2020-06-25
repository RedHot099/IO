package pl.poznan.put.cs.io.errors.storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Controls loading data from the given input.
 */
public class DataInput {

    int[][] matrix;
    private String inputName;
    private int size;
    private List<Double> numbers = new ArrayList<Double>();

    public DataInput(String inputName) {
        this.inputName = inputName;

    }

    private void initailizeMatrix() {
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    /**
     * Loads data from the given input. The first line is the number of .
     *
     * @throws throws Exception
     */
    public void load() throws Exception {
        numbers.clear();
        BufferedReader input = getBufferedReader();
        try {
            String line = null;
            int y = 0;
            // read operation
            line = input.readLine();
            if (line != null) {
                size = Integer.parseInt(line.trim());
            }
            initailizeMatrix();
            while ((line = input.readLine()) != null && line.length() > 0) {
                for (int i = 0; i < line.length(); i++) matrix[y][i] = Integer.parseInt(String.valueOf(line.charAt(i)));
                y++;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException ex) {
                throw ex;
            }
        }
    }

    /**
     * Setting output reader
     *
     * @return BufferRender loading given input into program
     * @throws throws FileNotFoungException
     */
    private BufferedReader getBufferedReader() throws FileNotFoundException {
        if (inputName.equalsIgnoreCase("console")) {
            return new BufferedReader(new InputStreamReader(System.in));
        }
        return new BufferedReader(new FileReader(new File(inputName)));
    }

    /**
     * Forwarding input matrix of graph
     *
     * @return matrix martix of graph connections
     */
    public int[][] getMatrix() {
        return matrix;
    }

}
