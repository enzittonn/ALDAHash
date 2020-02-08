public class DoubleHashingProbingHashTable<T> extends ProbingHashTable<T> {

    /*
     * Denna metod ska skrivas klart. Den ska använda bokens förslag på andra
     * hashalgoritm: f(i) = i * hash2(x), där hash2(x) = R - (x mod R) och R är
     * ett primtal mindre än tabellstorleken.
     */
    @Override
    protected int findPos(T x) {
        int currentPos = myhash(x);
        int stepSize = hashAlgoFunc(x);

        while (continueProbing(currentPos, x)) {
            currentPos += stepSize;
            if (currentPos >= capacity())
                currentPos -= capacity();
        }
        return currentPos;

    }

    private int hashAlgoFunc(T x) {
        int hashValue = x.hashCode();
        int index = smallerPrimeThanCapacity();

        int algoVal = index - hashValue % index;

        if (algoVal < 0)
            algoVal += index;

        return algoVal;

    }


    /*
     * Denna metod ger ett primtal mindre än tabellens storlek. Detta primtal ska
     * användas i metoden ovan.
     */
    protected int smallerPrimeThanCapacity() {
        int n = capacity() - 2;
        while (!isPrime(n)) {
            n -= 2;
        }
        return n;
    }

}
