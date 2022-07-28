public class Level1 {
    public static int[] SynchronizingTables(int n, int[] ids, int[] salary) {
        int[] idsTmp = new int[n];
        int[] salTmp = new int[n];

        int[] salFin = new int[n];

        for (int i = 0; i < n; i++) {
            idsTmp[i] = ids[i];
            salTmp[i] = salary[i];
        }

        boolean flag = true;
        while (flag) {
            flag = false;

            for (int i = 0; i < n - 1; i++) {
                if (idsTmp[i + 1] < idsTmp[i]) {
                    int t = idsTmp[i];

                    idsTmp[i] = idsTmp[i + 1];
                    idsTmp[i + 1] = t;

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
                if (ids[i] == idsTmp[j]) {
                    salFin[i] = salTmp[j];
                    break;
                }
            }
        }

        return salFin;
    }
}
