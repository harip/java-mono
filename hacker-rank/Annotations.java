import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@interface NonNull {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@interface NonNegative {}

class Hospital {
    public static String[] addPatientsDetails(
        @NonNull String[] input, 
        @NonNegative int n, 
        @NonNull String detailsToBeAdded) {
        String[] result = Arrays.copyOf(input, n+1);
        result[n] = detailsToBeAdded;
        return result;
    }
    
    public static String[] removePatientsDetails(
        @NonNull String[] input, 
        @NonNegative int n,
        @NonNull String patientIdToRemove) {
        List<String> resultList = new ArrayList<String>(Arrays.asList(input));
        for (String patient : input) {
            String[] details = patient.split(",");
            if (details[0].equals(patientIdToRemove)) {
                resultList.remove(patient);
                break;
            }
        }
        return resultList.toArray(new String[n-1]);
    }
    
    public static String[] updatePatientsDetails(
        @NonNull String[] input, 
        @NonNegative int n, 
        @NonNull String patientIdToUpdate,
        @NonNull String patientDetailsToUpdate) {
        List<String> resultList = new ArrayList<String>(Arrays.asList(input));
        for (int i = 0; i < resultList.size(); i++) {
            String patient = resultList.get(i);
            String[] details = patient.split(",");
            if (details[0].equals(patientIdToUpdate)) {
                resultList.set(i, patientDetailsToUpdate);
                break;
            }
        }
        return resultList.toArray(new String[n]);
    }  
}

class TypeAnnotation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		String input[] = new String[n];
		for (int i = 0; i < n; i++) {
			input[i] = br.readLine();
		}
		int query = Integer.parseInt(br.readLine().trim());
        if (query == 1) {			
			String detailsToBeAdded = br.readLine();
			String[] result1 = Hospital.addPatientsDetails(input, n, detailsToBeAdded);
			for (int i = 0; i < (n+1); i++) {
				System.out.println(result1[i]);
			}
		}
		if (query == 2) {
			String patientIdToRemove = br.readLine();
			String[] result2 = Hospital.removePatientsDetails(input, n, patientIdToRemove);
			for (int i = 0; i < (n-1); i++) {
				System.out.println(result2[i]);
			}
		}
		if (query == 3) {
			String patientIdToUpdate = br.readLine();
			String patientDetailsToUpdate = br.readLine();
			String[] result3 = Hospital.updatePatientsDetails(input, n, patientIdToUpdate, patientDetailsToUpdate);
			for (int i = 0; i < n ; i++) {
				System.out.println(result3[i]);
			}
		}
		br.close();
	}
}