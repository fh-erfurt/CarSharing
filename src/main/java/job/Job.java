package job;

import listener.jobstatelistener.OnCompleteListener;
import listener.jobstatelistener.OnFailureListener;
import listener.jobstatelistener.OnSuccessListener;

import java.util.concurrent.Executor;

public abstract class Job<ReportT> {
    public Job() {

    }

    abstract Job<ReportT> addOnCompleteListener(OnCompleteListener<ReportT> listener);
    abstract Job<ReportT> addOnCompleteListener(Executor executor, OnCompleteListener<ReportT> listener);
    abstract Job<ReportT> addOnFailureListener(OnFailureListener listener);
    abstract Job<ReportT> addOnFailureListener(Executor executor, OnFailureListener listener);
    abstract Job<ReportT> addOnSuccessListener(OnSuccessListener<? super ReportT> listener);
    abstract Job<ReportT> addOnSuccessListener(Executor executor, OnSuccessListener<? super ReportT> listener);

    abstract Exception getException();
    abstract ReportT getReport() throws IllegalStateException, RuntimeException;

    abstract boolean isComplete();
    abstract boolean isSuccessful();

}
