public class Level1 {
    public static int[] SynchronizingTables(int n, int[] ids, int[] salary) {
        int[] listEmployeesIdTemp = new int[n];
        int[] salTmp = new int[n];

        int[] orderedListSalaries = new int[n];

        for (int i = 0; i < n; i++) {
            listEmployeesIdTemp[i] = ids[i];
            salTmp[i] = salary[i];
        }

        boolean flag = true;
        while (flag) {
            flag = false;

            for (int i = 0; i < n - 1; i++) {
                if (listEmployeesIdTemp[i + 1] < listEmployeesIdTemp[i]) {
                    int t = listEmployeesIdTemp[i];

                    listEmployeesIdTemp[i] = listEmployeesIdTemp[i + 1];
                    listEmployeesIdTemp[i + 1] = t;

                    flag = true;
                }

                if (salTmp[i + 1] < salTmp[i]) {
                    int t = salTmp[i];

                    salTmp[i] = salTmp[i + 1];
                    salTmp[i + 1] = t;

                    flag = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ids[i] == listEmployeesIdTemp[j]) {
                    orderedListSalaries[i] = salTmp[j];
                    break;
                }
            }
        }

        return orderedListSalaries;
    }
}
