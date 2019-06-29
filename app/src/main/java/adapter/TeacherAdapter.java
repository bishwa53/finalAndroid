package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asmntclass.R;

import java.util.List;

import model.Teacher;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherHolder>{

    private List<Teacher> teacherList;
    private Context context;

    public TeacherAdapter(List<Teacher> teacherList, Context context){
        this.teacherList= teacherList;
        this.context = context;
    }


    @NonNull
    @Override
    public TeacherHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.teacher_content, viewGroup,false);
        return new TeacherHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherHolder teacherHolder, int i) {

        final Teacher teacher= teacherList.get(i);
//        setting values in recyclerView
        teacherHolder.tvFirstNameTeacher.setText(teacher.getTeacher_firstname());
        teacherHolder.tvLastNameTeacher.setText(teacher.getTeacher_lastname());
        teacherHolder.tvContactTeacher.setText(teacher.getTeacher_contactnumber());
        teacherHolder.tvAddressTeacher.setText(teacher.getTeacher_address());
        teacherHolder.tvUsernameTeacher.setText(teacher.getTeacher_username());
        teacherHolder.tvPasswordTeacher.setText(teacher.getTeacher_password());
    }


    @Override
    public int getItemCount() {
        return teacherList.size();
    }

    public class TeacherHolder extends RecyclerView.ViewHolder
    {
        private TextView tvFirstNameTeacher,tvLastNameTeacher,tvContactTeacher,tvAddressTeacher,tvUsernameTeacher,tvPasswordTeacher;

        public TeacherHolder(View itemView) {
            super(itemView);
            tvFirstNameTeacher= itemView.findViewById(R.id.tvFirstNameTeacher);
            tvLastNameTeacher= (TextView) itemView.findViewById(R.id.tvLastNameTeacher);
            tvContactTeacher= (TextView) itemView.findViewById(R.id.tvContactTeacher);
            tvAddressTeacher= (TextView) itemView.findViewById(R.id.tvAddressTeacher);
            tvUsernameTeacher= (TextView) itemView.findViewById(R.id.tvUsernameTeacher);
            tvPasswordTeacher= (TextView) itemView.findViewById(R.id.tvPasswordTeacher);
            }
    }
}
