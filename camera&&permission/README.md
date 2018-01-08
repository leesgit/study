# Camera
Gallery �� Camera ����� ����غ���.


## ����üũ


 <!-- ������ �����ϱ� ���� ���Ͽ� ���� ������ ȹ���ϱ� ���� ���� -->
        <provider
            android:name="android.support.v4.content.FileProvider"
            android:authorities="${applicationId}.provider"
            android:exported="false"
            android:grantUriPermissions="true">
            <!-- resource ������ res/xml �����ȿ� ���� -->
            <meta-data
                android:name="android.support.FILE_PROVIDER_PATHS"
                android:resource="@xml/file_path"/>
        </provider>
(�Ѹ��� �̻� ������ provider �� ����ؾ��Ѵ�. (contentProvider ���� �ٸ� ��) ���� manifest�� ������ �����ϱ� ���� ���Ͽ� ���� ������ ȹ���ϱ� ���� ������ �ؾ��Ѵ�. xml ������ ������ ����. (�ȵ���̵� �޴��佺Ʈ ���ι��̴� �˻�)

authorities = "��Ű����.provider" �� �ؾ������� �׷��� �Ӽ����� �ҷ��ͼ� ���� ���� ǥ���� �� �ִ�.

<paths>
    <!-- path = /External Storage/CameraN �� �ȴ� -->
    <!-- name = content:// �� �����ϴ� uri �ּ�ü���� suffix�� �ȴ�. -->

    <external-path name = "Camera" path = "CameraN"/>
</paths>
���ҽ� ������ ������ ��� �����. res - xml - file_path �����



- Ư�� ������ �ִ��� �ý��ۿ� �����.
```java
  // ���ø�� �̻� ���������� ��Ÿ�� ���� üũ
  if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      // level 23�� ���ø���̴�.  Build.VERSION_CODES.M : ���ø�θ� ����Ų��.
      // ���ø�κ��ʹ� �տ� �빮�� ���ڸ� �ᵵ �ȴ�.
      checkPermission();
  } else {
      // �ƴϸ� �׳� run() �޼ҵ� ����
      init();
  }


  }

  @TargetApi(Build.VERSION_CODES.M)       // @RequireApi �� @TargetApi �� �����ϴٰ� �����ص� �ȴ�.
  private void checkPermission() {
  // 1. ����üũ - Ư�������� �ִ��� �ý��ۿ� �����.
  // checkSelfPermission ��ȯ���� true, false�� �ƴ϶� �̸� ���ǵ� ����� ��ȯ�Ѵ�.
  if( checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
          && checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
      init();
  } else {
      // 2. ������ ������ ����ڿ��� ������ �޶�� ��û
      String permissions[] = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}; // ���ÿ� ������ ȣ���� �� �����ϱ� ������
      requestPermissions(permissions , REQ_PERMISSION);  // -> ������ �䱸�ϴ� �˾��� ����� ȭ�鿡 ����ȴ�.

  }
  }

  // 3. ����ڰ� ����üũ �˾����� ������ ���� �Ǵ� �����ϸ� �Ʒ� �޼��尡 ȣ��ȴ�.
  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
  super.onRequestPermissionsResult(requestCode, permissions, grantResults);
  if(requestCode == REQ_PERMISSION) {
      // 3.1 ����ڰ� ������ ����.
      if(grantResults[0] == PackageManager.PERMISSION_GRANTED
              && grantResults[1] == PackageManager.PERMISSION_GRANTED){
          init();
      // 3.2 ����ڰ� ���� ����.
      } else {
          cancel();
      }
  }
  }
```

## Camera ��� �̿�
- **�Ѹ��� ��������** �� ���� ȹ����� ����� �����ϳ�
  **���ø�� �̻� ����** �� ���� ���ι��̴��� ���� ������ ȹ��

```java
  Uri fileUri = null;
  private void takePhoto(){
      Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
      if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
          File photoFile = null;
          try {
              photoFile = createFile();   //������ ���� ��´�.

              if(photoFile != null){
                  // ���ø�� �̻� ������ ���� ���ι��̴��� ���� ������ ȹ��
                  if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                      fileUri = FileProvider.getUriForFile(getBaseContext(), BuildConfig.APPLICATION_ID+".provider", photoFile);
                  // �Ѹ��� ������ ���� ���� ȹ���� ����
                  } else {
                      fileUri = Uri.fromFile(photoFile);
                  }
                  intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                  startActivityForResult(intent, Const.Camera.REQ_CAMERA);
              }
          }catch(Exception e){
              //  e.printStackTrace();  -> ����ó������ ������ ���� �̷��� ���ָ� ������ Ȯ���� �� �ִ�.
              Toast.makeText(getBaseContext(), "�������� ������ ���� �ӽ������� ������ �� �����ϴ�.", Toast.LENGTH_SHORT).show();
              return;  // ���������� �����ȵǸ� ���̻� ������� �ʰ� �Ϸ��� return; �Ѵ�.
          }

      } else { // �Ѹ��� �̸� ���������� �ٷ� ����
          startActivityForResult(intent, Const.Camera.REQ_CAMERA);
      }
  }

  private File createFile() throws IOException{
      // �ӽ����ϸ� ����
      String tempFileName = "TEMP_"+System.currentTimeMillis();
      // �ӽ����� ����� ���丮 ����
      File tempDir = new File(Environment.getExternalStorageDirectory() + "/CameraN/");
      // Environment.getExternalStorageDirectory() : ��Ʈ��θ� ������.
      if(!tempDir.exists()){
          tempDir.mkdir();
      }
      // ���� �ӽ������� ����
      File tempFile = File.createTempFile(
              tempFileName,
              ".jpg",
              tempDir
      );
      return tempFile;
  }

  @Override
      protected void onActivityResult(int requestCode, int resultCode, Intent data) {
          super.onActivityResult(requestCode, resultCode, data);
          // ��û�ڵ� ����
          if(requestCode == Const.Camera.REQ_CAMERA){
              // ���ó�� ���� ����
              if(resultCode == RESULT_OK) {
                  Uri imageUri = null;
                  // �Ѹ��� �̸� ���������� data ����Ʈ�� ���� ������ uri �� ��ܿ´�.
                  if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
                      imageUri = data.getData();
                  } else {
                      imageUri = fileUri;
                  }
                  Log.i("Camera","file=============================="+fileUri);
                  Log.i("Camera","file=============================="+imageUri);
                  imageView.setImageURI(imageUri);
              }
          }
      }
```