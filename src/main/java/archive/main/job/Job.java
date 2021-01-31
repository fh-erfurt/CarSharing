package archive.main.job;

import archive.main.job.statelistener.OnCompleteListener;
import archive.main.job.statelistener.OnFailureListener;
import archive.main.job.statelistener.OnSuccessListener;

import java.util.concurrent.Executor;

public abstract class Job<ReportT> {
    public Job() {

    }

    public abstract Job<ReportT> addOnCompleteListener(OnCompleteListener<ReportT> listener);
    public abstract Job<ReportT> addOnCompleteListener(Executor executor, OnCompleteListener<ReportT> listener);
    public abstract Job<ReportT> addOnFailureListener(OnFailureListener listener);
    public abstract Job<ReportT> addOnFailureListener(Executor executor, OnFailureListener listener);
    public abstract Job<ReportT> addOnSuccessListener(OnSuccessListener<? super ReportT> listener);
    public abstract Job<ReportT> addOnSuccessListener(Executor executor, OnSuccessListener<? super ReportT> listener);

    public abstract Exception getException();
    public abstract ReportT getReport() throws IllegalStateException, RuntimeException;

    public abstract boolean isComplete();
    public abstract boolean isSuccessful();

}
