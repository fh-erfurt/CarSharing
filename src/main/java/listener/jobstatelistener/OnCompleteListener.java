package listener.jobstatelistener;

import job.Job;

public interface OnCompleteListener<ReportT> {
    void onComplete(Job<ReportT> job);
}
