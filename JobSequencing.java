import java.util.*;

class Job {
    char id;     // Job ID
    int deadline;
    int profit;

    Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {
    // Function to schedule jobs
    public static void jobScheduling(Job[] jobs, int n) {
        // Sort jobs by descending profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find maximum deadline
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        // Result array to store scheduled jobs
        char[] result = new char[maxDeadline];
        boolean[] slot = new boolean[maxDeadline];

        // Initialize slots
        Arrays.fill(slot, false);

        // Iterate through jobs
        for (Job job : jobs) {
            // Find a free slot for this job (before deadline)
            for (int j = Math.min(maxDeadline, job.deadline) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    result[j] = job.id;
                    break;
                }
            }
        }

        // Print scheduled jobs
        System.out.println("Scheduled Jobs:");
        for (int i = 0; i < maxDeadline; i++) {
            if (slot[i]) {
                System.out.print(result[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job('A', 2, 100),
            new Job('B', 1, 19),
            new Job('C', 2, 27),
            new Job('D', 1, 25),
            new Job('E', 3, 15)
        };

        jobScheduling(jobs, jobs.length);
    }
}
