package archive.main.job.statelistener;

import archive.main.job.Job;

public interface OnCompleteListener<ReportT> {
    void onComplete(Job<ReportT> job);
}
