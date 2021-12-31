<template>
  <div class="hello">
    <el-table :data="getData">
      <el-table-column label="Tên" prop="name"></el-table-column>
      <el-table-column label="Ngày sinh" prop="birthday"></el-table-column>
      <el-table-column label="Địa chỉ" prop="address"></el-table-column>
      <el-table-column label="Nghề" prop="job"></el-table-column>
      <el-table-column label="Kết hôn" prop="marital"></el-table-column>
      <el-table-column label="Sở thích" prop="interest"></el-table-column>
      <el-table-column
        label="Số điện thoại"
        prop="phonenumber"
      ></el-table-column>
      <el-table-column align="center">
        <span slot-scope="scope"
          ><el-button @click="detail(scope.row)">Detail</el-button>
          <el-button @click="del(scope.row.Id)">Xóa</el-button>
        </span>
      </el-table-column> 
    </el-table>

    <input
      label="ID"
      horizontal
      disabled
      autocomplete="id"
      v-model="formData.id"
      value="this.formData.id + 1"
    />
    <input
      label="Enter your name"
      horizontal
      autocomplete="name"
      v-model="formData.name"
    />
    <input
      label="Birthday"
      type="date"
      horizontal
      v-model="formData.birthday"
    />
    <input
      label="Your address"
      horizontal
      autocomplete="address"
      v-model="formData.address"
    />
    <input
      label="PhoneNumber"
      horizontal
      autocomplete="phonenumber"
      v-model="formData.phonenumber"
    />
    <input label="Job" horizontal autocomplete="job" v-model="formData.job" />
    <div style="float: left">
      Martital Status
    </div>
    <div class="btn-group" data-toggle="buttons" style="margin-left: 20%;">
      <label class="btn">
        <input
          @click="formData.martital = 'yes'"
          horizontal
          name="martital"
          type="radio"
        />
        Yes
      </label>
      <label class="btn">
        <input
          @click="formData.martital = 'no'"
          horizontal
          name="martital"
          type="radio"
        />
        No
      </label>
    </div>
    <input
      label="Interests"
      horizontal
      autocomplete="interests"
      v-model="formData.interests"
    />
    <button
      type="submit"
      size="sm"
      color="primary"
      style="margin-left: 1.5em"
      @click="postDT()"
    >
      <CIcon name="cil-check-circle" /> Submit
    </button>
    <button
      type="reset"
      size="sm"
      color="danger"
      @click="resetInput()"
      style="margin-left: 1.5em"
    >
      <CIcon name="cil-ban" /> Reset
    </button>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "HelloWorld",
  props: {
    msg: String,
  },
  data() {
    return {
      getData: "",
      formData: {
        name: "",
        birthday: "",
        address: "",
        job: "",
        marital: "",
        interest: "",
        phonenumber: "",
      },
    };
  },
  created() {
    this.getDT();
  },
  methods: {
    callFunction: function() {
      var v = this;
      setTimeout(function() {
        v.getDT();
      }, 2000);
    },
    getDT() {
      console.log("test Data");
      axios
        .get("https://61236eae124d88001756824a.mockapi.io/UserName")
        .then((response) => {
          console.log(response); //dùng để đọc xem các data bên trong nó có gì ?
          this.getData = response.data;
        });
      console.log(this.getData);
    },
    postDT() {
      const formData = new FormData();
      for (let index in this.formData) {
        formData.append(index, this.formData.index);
      }
      console.log(this.formData);
      axios
        .post(
          "https://61236eae124d88001756824a.mockapi.io/UserName",
          this.formData
        )
        .then(function() {
          alert("Success!");
        })
        .catch(function(error) {
          alert(error);
        });
      this.callFunction();
    },
    resetInput() {
      this.formData.name = this.formData.birthday = this.formData.address = this.formData.phonenumber = this.formData.martital = this.formData.interests = this.formData.job =
        "";
    },
    deleteItem(id) {
      console.log(id);
      axios
        .delete("https://61236eae124d88001756824a.mockapi.io/UserName/" + id)
        .then(function thanhcong() {
          alert("Success!");
        })
        .catch(function(error) {
          alert(error);
        });
      this.callFunction();
    },
    updateItem(row) {
      console.log(row);
      this.$router.push({
        name: "Update",
        params: { update: row },
      });
    },
  },
};
</script>

<style scoped></style>
