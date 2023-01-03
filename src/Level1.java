public class Level1 {
    public static int[] SynchronizingTables(int n, int[] ids, int[] salary) {
        // создаем временные копии массивов для работы
        int[] listEmployeesIdTemp = new int[n];
        int[] listSalariesTemp = new int[n];
        System.arraycopy(ids, 0, listEmployeesIdTemp, 0, n);
        System.arraycopy(salary, 0, listSalariesTemp, 0, n);

        // сортируем массивы по возрастанию
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < n - 1; i++) {
                if (listEmployeesIdTemp[i + 1] < listEmployeesIdTemp[i]) {
                    int t = listEmployeesIdTemp[i];

                    listEmployeesIdTemp[i] = listEmployeesIdTemp[i + 1];
                    listEmployeesIdTemp[i + 1] = t;

                    isSorted = false;
                }

                if (listSalariesTemp[i + 1] < listSalariesTemp[i]) {
                    int t = listSalariesTemp[i];

                    listSalariesTemp[i] = listSalariesTemp[i + 1];
                    listSalariesTemp[i + 1] = t;

                    isSorted = false;
                }
            }
        }

        // синхронизируем таблицы
        int[] orderedListSalaries = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ids[i] == listEmployeesIdTemp[j]) {
                    orderedListSalaries[i] = listSalariesTemp[j];
                    break;
                }
            }
        }

        return orderedListSalaries;
    }
}
