
import React from 'react';
import {
    View,
    Text,
    Image,
    TouchableOpacity,
    StyleSheet,
    ScrollView
} from 'react-native';
import { IconButton,TextButton,LineDivider, ProgressBar, ProfileValue, ProfileRadioButton } from '../../components';
import { COLORS,FONTS,SIZES,icons,images } from '../../constants';

const Profile = () => {

    const [newCourseNotification,setNewCourseInformation] = React.useState(false);
    const [studyReminder, setStudyReminder] = React.useState(false);

    function renderHeader() {
    return(
        <View
            style={{
                flexDirection:'row',
                marginTop:50,
                paddingHorizontal:SIZES.padding,
                justifyContent:'space-between'
            }}
        >
            <Text 
                style={{
                    ...FONTS.h1
                }}
                >
                    Profile
            </Text>
            <IconButton
                    icon={icons.sun}
                    iconStyle={{
                        tintColor: COLORS.black
                    }}
                />
        </View>
    )
}

function renderProfileCard(){
    return(
        <View style={{
            flexDirection:'row',
            marginTop:SIZES.padding,
            paddingHorizontal:SIZES.radius,
            paddingVertical:20,
            borderRadius:SIZES.radius,
            backgroundColor:COLORS.primary3
        }}>
            {/* Profile Image */}
            <TouchableOpacity style={{
                width:80,
                height:80
            }}>
                <Image 
                    source={images.profile}
                    style={{
                        width:'100%',
                        height:"100%",
                        borderRadius:40,
                        borderWidth:1,
                        borderColor:COLORS.white
                    }}
                    />
                    <View
                    style={{
                        position:'absolute',
                        width:'100%',
                        height:'100%',
                        alignItems:'cennter',
                        justifyContent:'flex-end'
                    }}>
                        <View style={{
                            width:30,
                            height:30,
                            left:22,
                            marginBottom:-15,
                            alignItems:'center',
                            justifyContent: 'center',
                            borderRadius:15,
                            backgroundColor:COLORS.primary
                        }}>
                            <Image
                                source={icons.camera}
                                resizeMode='contain'
                                style={{
                                    width:17,
                                    height:17
                                }}
                                />
                        </View>

                    </View>
            </TouchableOpacity>
            {/* Details - profile */}
            <View style={{
                flex:1,
                marginLeft:SIZES.radius,
                alignItems:'flex-start'
            }}>
                <Text style={{
                    color: COLORS.white,
                    ...FONTS.h2,
                    fontWeight:'bold'
                }}>
                    Martin Benik
                </Text>
                <Text style={{
                    color: COLORS.white,
                    ...FONTS.body4,
                   
                }}>
                    Foundner 
                </Text>
                {/* ProgressBar */}
                <ProgressBar
                    progress="48%"
                    containerStyle={{
                        marginTop: SIZES.radius
                    }}
                    />
                    <View style={{
                        flexDirection: 'row',
                        color: COLORS.white,
                        ...FONTS.body4,
                    }}>
                        <Text style={{
                        flex:1,
                        color: COLORS.white,
                        ...FONTS.body4,
                    }}
                    >
                            Overall Progress
                        </Text>
                        <Text style={{
                        color: COLORS.white,
                        ...FONTS.body4,
                    }}>
                                48%
                        </Text>
                    </View>

                    {/* Membership */}
                    <TextButton 
                    label="+ Become Member"
                    contentContainerStyle={{
                        height:35,
                        marginTop: SIZES.padding,
                        paddingHorizontal: SIZES.radius,
                        borderRadius:20,
                        backgroundColor: COLORS.white
                    }}
                    labelStyle={{
                        color:COLORS.primary
                    }}
                    />
            </View>
        </View>
    )
}

function renderProfileSection1(){
    return (
        <View style={styles.profileSectionContnainer}>
            <ProfileValue
            icon={icons.profile}
            label="Name"
            value="Martin Benik" 
            />

            <LineDivider/>

            <ProfileValue
            icon={icons.email}
            label="Email"
            value="MartinBenik@randomemail.com" 
            />
               <LineDivider/>

            <ProfileValue
            icon={icons.password}
            label="Password"
            value="Update 2 weeks ago" 
            />
            <LineDivider/>

            <ProfileValue
            icon={icons.call}
            label="Contact Number"
            value="+1(916)555-555" 
            />

        </View>
    )
}

function renderProfileSection2(){
    return(
        <View style={styles.profileSectionContnainer}>
            <ProfileValue
                icon={icons.star}
                value="Pages"
                />

                <LineDivider/>

                <ProfileRadioButton 
                icon={icons.new_icon}
                label="New Course Notification"
                isSelected={newCourseNotification}
                onPress={() => {
                    setNewCourseInformation(!newCourseNotification)
                }}
                />

                <LineDivider/>

                <ProfileRadioButton 
                icon={icons.time}
                label="Study Reminder"
                isSelected={studyReminder}
                onPress={() => {
                    setStudyReminder(!studyReminder)
                }}
                />

        </View>
    )
}

    return (
        <View>
                 {/* Header Section*/}
                  {renderHeader()}

                  {/* Content Section */}
                  <ScrollView
                  showsVerticalScrollIndicator={false}
                  contentContainerStyle={{
                    paddingHorizontal: SIZES.padding,
                    paddingBottom:150
                  }}
                  >
                    {/* Profile Card */}
                    {renderProfileCard()}


                    {/* Profile Section 1 */}
                    {renderProfileSection1()}

                    {/* Profile Section 2 */}
                    {renderProfileSection2()}


                  </ScrollView>
        </View>
        
        
    )
}

const styles = StyleSheet.create({
    profileSectionContnainer: {
        marginTop: SIZES.padding,
        paddingHorizontal: SIZES.padding,
        borderWidth: 1,
        borderRadius: SIZES.radius,
        borderColor: COLORS.gray20
    }
})

export default Profile;