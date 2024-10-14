//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.campusdual;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    public static final Random random = new Random();
    public static final DecimalFormat dF = new DecimalFormat("#.##");

    private Utils() {
    }

    public static String init() {
        String buffer = "";
        InputStreamReader stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(stream);

        try {
            buffer = reader.readLine();
        } catch (Exception var4) {
            System.out.append("Invalid data.");
        }

        return buffer;
    }

    public static int integer() {
        return integer((String)null);
    }

    public static int integer(String message) {
        if (message != null) {
            System.out.print(message);
        }

        try {
            return Integer.parseInt(init());
        } catch (NumberFormatException var2) {
            System.out.println("The value is not an integer.");
            return integer(message);
        }
    }

    public static double real() {
        return real((String)null);
    }

    public static double real(String message) {
        if (message != null) {
            System.out.print(message);
        }

        try {
            return Double.parseDouble(init());
        } catch (NumberFormatException var2) {
            System.out.println("Value is not a real number.");
            return real(message);
        }
    }

    public static String string() {
        return string((String)null);
    }

    public static String string(String message) {
        if (message != null) {
            System.out.print(message);
        }

        return init();
    }

    public static char character() {
        return character((String)null);
    }

    public static char character(String message) {
        if (message != null) {
            System.out.print(message);
        }

        String valor = init();
        return valor.charAt(0);
    }

    public static String formatLocalNumber(double d) {
        return dF.format(d);
    }

    public static int getRandomNumberInRange(int min, int max) {
        ++max;
        return random.nextInt(max - min) + min;
    }

    public static <T> void showFromList(List<T> list, boolean wait) {
        showFromList(list, wait, (List)null);
    }

    public static <T> void showFromList(List<T> list, boolean wait, List<T> excludeElements) {
        StringBuilder builder = new StringBuilder();
        List<Object> auxList = new ArrayList();
        auxList.addAll(list);
        if (excludeElements != null) {
            auxList.removeAll(excludeElements);
        }

        for(int i = 0; i < auxList.size(); ++i) {
            builder.append("\t");
            builder.append(i + 1);
            builder.append(". ");
            builder.append(auxList.get(i).toString());
            builder.append("\n");
        }

        System.out.print(builder.toString());
        if (wait) {
            string("\nPress \"Enter\" to continue...");
        }

    }

    public static <T> String returnShowFromList(List<T> list, boolean id) {
        return returnShowFromList(list, id, (List)null);
    }

    public static <T> String returnShowFromList(List<T> list, boolean id, List<T> excludeElements) {
        StringBuilder builder = new StringBuilder();
        List<Object> auxList = new ArrayList();
        auxList.addAll(list);
        if (excludeElements != null) {
            auxList.removeAll(excludeElements);
        }

        for(int i = 0; i < auxList.size(); ++i) {
            builder.append("\t");
            if (id) {
                builder.append(i + 1);
                builder.append(". ");
            }

            builder.append(auxList.get(i).toString());
            builder.append("\n");
        }

        return builder.toString();
    }

    public static <T> List<T> showAndSelectFromList(List<T> list, boolean cancel) {
        return showAndSelectFromList(list, cancel, false);
    }

    public static <T> List<T> showAndSelectFromList(List<T> list, boolean cancel, boolean multipleReturn) {
        return showAndSelectFromList(list, cancel, multipleReturn, (List)null);
    }

    public static <T> List<T> showAndSelectFromList(List<T> list, boolean cancel, boolean multipleReturn, List<T> excludeElements) {
        showFromList(list, false, excludeElements);
        List<T> auxList = new ArrayList(list);
        List<T> toRet = new ArrayList();
        if (excludeElements != null) {
            auxList.removeAll(excludeElements);
        }

        StringBuilder builder = new StringBuilder();
        if (!multipleReturn) {
            builder.append("\nSelect the desired item");
            if (cancel) {
                builder.append(", 0 to exit");
            }

            builder.append(": ");

            int selected;
            for(selected = integer(builder.toString()); !checkSelection(selected, list.size()) && selected != 0; selected = integer("The option is not valid, please choose a valid option: ")) {
            }

            if (selected == 0) {
                return toRet;
            } else {
                toRet.add(auxList.get(selected - 1));
                return toRet;
            }
        } else {
            builder.append("\nSelect the desired items, separating them by , ");
            if (cancel) {
                builder.append("(0 to exit)");
            }

            builder.append(": ");
            String auxSelected = string(builder.toString());
            auxSelected = auxSelected.replace(" ", "");
            String[] split = auxSelected.split(",");
            int[] selectionIndex = parseIntArray(split);
            if (selectionIndex[0] < 0) {
                return toRet;
            } else {
                for(int i = 0; i < selectionIndex.length; ++i) {
                    toRet.add(auxList.get(selectionIndex[i]));
                }

                return toRet;
            }
        }
    }

    static int[] parseIntArray(String[] arr) {
        ArrayList<Integer> list = new ArrayList();

        for(int i = 0; i < arr.length; ++i) {
            list.add(Integer.valueOf(arr[i]) - 1);
        }

        return list.stream().mapToInt((ix) -> {
            return ix;
        }).toArray();
    }

    public static boolean checkSelection(int i, int size) {
        return i >= 1 && i <= size;
    }
}
