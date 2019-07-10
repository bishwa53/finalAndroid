package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asmntclass.R;
import com.example.asmntclass.ViewAttendanceActivity;

import java.util.List;

import model.Attendance;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.AttendanceHolder>{
    private List<Attendance> attendanceList;
    private Context context;

    public AttendanceAdapter(List<Attendance> attendanceList, Context context) {
        this.attendanceList= attendanceList;
        this.context = context;
    }

    @NonNull
    @Override
    public AttendanceAdapter.AttendanceHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceAdapter.AttendanceHolder attendanceHolder, int i) {
        final Attendance attendance= attendanceList.get(i);

        //        setting values in recyclerView

        attendanceHolder.tvAttendanceStatus.setText(attendance.getStatus());
        attendanceHolder.tvAttendanceDate.setText(attendance.getAttDate());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AttendanceHolder extends RecyclerView.ViewHolder {

        private TextView tvAttendanceStatus,tvAttendanceDate;

        public AttendanceHolder(@NonNull View itemView) {

            super(itemView);
            tvAttendanceStatus= itemView.findViewById(R.id.tvAttendanceStatus);
            tvAttendanceDate= itemView.findViewById(R.id.tvAttendanceDate);
        }
    }
}
